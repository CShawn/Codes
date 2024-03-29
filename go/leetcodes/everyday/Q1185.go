/**
一周中的第几天
给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
输入为三个整数：day、month 和 year，分别表示日、月、年。
您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。

示例 1：
输入：day = 31, month = 8, year = 2019
输出："Saturday"

示例 2：
输入：day = 18, month = 7, year = 1999
输出："Sunday"

示例 3：
输入：day = 15, month = 8, year = 1993
输出："Sunday"

提示：给出的日期一定是在 1971 到 2100 年之间的有效日期。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/day-of-the-week
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author C.Shawn
 * @Date 2022/1/3 11:27
*/

package everyday

// 1969-12-31为周四，1970-2010之间只有一个整百数2000且为闰年，故不用判断400的倍数
func dayOfTheWeek(day int, month int, year int) string {
	weeks := [7]string{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}
	monthDays := [12]int{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30}
	days := 365*(year-1971) + (year-1969)/4
	for i := 0; i < month-1; i++ {
		days += monthDays[i]
	}
	if month > 3 && (year%400 == 0 || (year%4 == 0 && year%100 != 0)) {
		days++
	}
	days += day
	return weeks[(days+3)%7]
}
