/**
 * 获取每日一题
 * @Author C.Shawn
 * @Date 2022/1/5 09:34
 */

package main

import (
	"encoding/json"
	"errors"
	"fmt"
	"io/ioutil"
	"net/http"
	"os"
	"regexp"
	"strconv"
	"strings"
)

func main() {
	question, err := getQuestion()
	if err != nil {
		_ = fmt.Errorf("get question failed, %v", err)
	} else {
		createFile(question)
	}
}

func getQuestion() (Question, error) {
	everyData, err := request(getEveryData)
	if err == nil {
		var slugData EveryData
		err = json.Unmarshal(everyData, &slugData)
		if err == nil {
			slug := slugData.Data.TodayRecord[0].Question.TitleSlug
			everyData, err := request(getDetail(slug))
			if err == nil {
				var detail EveryDetail
				err = json.Unmarshal(everyData, &detail)
				if err == nil {
					question := detail.Data.Question
					question.Date = slugData.Data.TodayRecord[0].Date
					regex, err := regexp.Compile("<.*?>")
					if err == nil {
						question.Content = regex.ReplaceAllString(question.Content, "")
						question.TranslatedContent = regex.ReplaceAllString(question.TranslatedContent, "")
						return question, nil
					} else {
						_ = fmt.Errorf("regex error")
					}
				} else {
					_ = fmt.Errorf("parse Detail failed")
				}
			} else {
				_ = fmt.Errorf("getDetail failed")
			}
		} else {
			_ = fmt.Errorf("parse EveryData failed")
		}
	} else {
		_ = fmt.Errorf("getEveryData failed")
	}
	return Question{}, err
}

func createFile(question Question) {
	file, err := os.Create("./everyday/Q" + question.QuestionFrontendId + ".go")
	if err != nil {
		_ = fmt.Errorf("create file " + question.TitleSlug + " failed")
		return
	}
	defer file.Close()
	_, _ = file.Write([]byte("/**\n"))
	_, _ = file.Write([]byte(question.TranslatedTitle))
	_, _ = file.Write([]byte("\n"))
	_, _ = file.Write([]byte(question.TranslatedContent))
	_, _ = file.Write([]byte(" */\n"))
	_, _ = file.Write([]byte("package everyday\n"))
	for _, code := range question.CodeSnippets {
		if code.Lang == "Go" {
			_, _ = file.Write([]byte(code.Code))
			break
		}
	}
	//_, _ = file.Write([]byte(qus))
}

const urlString string = "https://leetcode-cn.com/graphql"

var getEveryData = "{\"query\":\"\\n" +
	"    query questionOfToday {\\n" +
	"  todayRecord {\\n" +
	"    date\\n" +
	"    userStatus\\n" +
	"    question {\\n" +
	"      questionId\\n" +
	"      frontendQuestionId: questionFrontendId\\n" +
	"      difficulty\\n" +
	"      title\\n" +
	"      titleCn: translatedTitle\\n" +
	"      titleSlug\\n" +
	"      paidOnly: isPaidOnly\\n" +
	"      freqBar\\n      isFavor\\n      acRate\\n      status\\n" +
	"      solutionNum\\n      hasVideoSolution\\n" +
	"      topicTags {\\n        name\\n" +
	"        nameTranslated: translatedName\\n        id\\n" +
	"      }\\n" +
	"      extra {\\n" +
	"        topCompanyTags {\\n" +
	"          imgUrl\\n          slug\\n          numSubscribed\\n" +
	"        }\\n" +
	"      }\\n" +
	"   }\\n" +
	"    lastSubmission {\\n      id\\n    }\\n" +
	"  }\\n" +
	"}\\n" +
	"    \",\"variables\":{},\"operationName\":\"questionOfToday\"}"

func getDetail(slug string) string {
	return "{\"operationName\":\"questionData\",\"variables\":{\"titleSlug\":\"" + slug + "\"},\"query\":\"query questionData($titleSlug: String!) {\\n" +
		"  question(titleSlug: $titleSlug) {\\n" +
		"    questionId\\n    questionFrontendId\\n    categoryTitle\\n    boundTopicId\\n    title\\n" +
		"    titleSlug\\n    content\\n    translatedTitle\\n    translatedContent\\n    isPaidOnly\\n    difficulty\\n" +
		"    likes\\n    dislikes\\n    isLiked\\n    similarQuestions\\n" +
		"    contributors {\\n" +
		"      username\\n      profileUrl\\n" +
		"      avatarUrl\\n      __typename\\n" +
		"    }\\n" +
		"    langToValidPlayground\\n" +
		"    topicTags {\\n" +
		"      name\\n      slug\\n      translatedName\\n      __typename\\n" +
		"    }\\n    companyTagStats\\n" +
		"    codeSnippets {\\n" +
		"      lang\\n      langSlug\\n      code\\n      __typename\\n" +
		"    }\\n    stats\\n    hints\\n" +
		"    solution {\\n      id\\n      canSeeDetail\\n      __typename\\n    }\\n" +
		"    status\\n    sampleTestCase\\n    metaData\\n    judgerAvailable\\n" +
		"    judgeType\\n    mysqlSchemas\\n    enableRunCode\\n    envInfo\\n" +
		"    book {\\n      id\\n      bookName\\n      pressName\\n      source\\n" +
		"      shortDescription\\n      fullDescription\\n      bookImgUrl\\n      pressImgUrl\\n" +
		"      productUrl\\n      __typename\\n    }\\n    isSubscribed\\n    isDailyQuestion\\n" +
		"    dailyRecordStatus\\n    editorType\\n    ugcQuestionId\\n    style\\n    exampleTestcases\\n" +
		"    __typename\\n  }\\n}\\n\"}"
}

func request(data string) ([]byte, error) {
	res, err := http.Post(urlString, "application/json", strings.NewReader(data))
	if err != nil {
		return nil, err
	}
	defer res.Body.Close()
	if res.StatusCode == 200 {
		d, err := ioutil.ReadAll(res.Body)
		if err != nil {
			return nil, err
		}
		return d, nil
	}
	return nil, errors.New(strconv.Itoa(res.StatusCode))
}
