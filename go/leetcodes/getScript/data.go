/**
 * @Author C.Shawn
 * @Date 2022/1/5 09:39
 */

package main

type DayRecord struct {
	Date     string   `json:"date"`
	Question Question `json:"question"`
}

type EveryData struct {
	Data SlugInfo
}

type EveryDetail struct {
	Data DayRecord
}

type Question struct {
	Date               string         `json:"date"`
	QuestionId         string         `json:"questionId"`
	QuestionFrontendId string         `json:"questionFrontendId"`
	TitleSlug          string         `json:"titleSlug"`
	Title              string         `json:"title"`
	TranslatedTitle    string         `json:"translatedTitle"`
	Content            string         `json:"content"`
	TranslatedContent  string         `json:"translatedContent"`
	Difficulty         string         `json:"difficulty"`
	TopicTags          []Tag          `json:"TopicTags"`
	Hints              []string       `json:"hints"`
	CodeSnippets       []CodeTemplate `json:"codeSnippets"`
}

type CodeTemplate struct {
	Lang     string `json:"lang"`
	LangSlug string `json:"langSlug"`
	Code     string `json:"code"`
	Typename string `json:"__typename"`
}

type SlugInfo struct {
	TodayRecord []DayRecord `json:"todayRecord"`
}

type Tag struct {
	TranslatedName string `json:"translatedName"`
}
