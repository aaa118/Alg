package com.company.general.kotlin

/**
 * \d Represents any number
 * \D Represents anything but a number
 * \s Represents any space
 * \S Anything but a space
 * \w Any character
 * \W Any but a character
 * \. Any character but a line break
 * \b Matches a space which precedes a whole word.
 *
 * ? 0 or 1 repetitions
 * * 0 or more repetitions
 * {n} e.g. \d{1,5} Expect between 1 and 5 digits in the row.
 */
class RegexExample {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            //            println(log())

            var string1 = "cat cat AND*Dogs-are Awesome"
            var string2 = "cat cat 11D*Dogs-are Awesome"
            var string3 = "cat cat 11D*Dogs-are Awesome"
            var dollar = "$100.00"
            var regexDollar = Regex("""\$\d*\.\d{2}""")

//            var regex = """cat\\/i""".toRegex()
            var regex = """cat""".toRegex(RegexOption.IGNORE_CASE)

            var regex1 = Regex("""\d""")
            var regex2 = Regex("""Jennifer\s\w+\s""")

//            var .pattern = /w3schools/i


            var res = dollar.contains(regexDollar)
            println(res)

//            println(LogDumpGetUnique())

        }


        fun log(): String {
            var log_dump: String =
                "name=John Trust, username=john3, email=john3@gmail.com, id=434453; name=Hannah Smith, username=" +
                        "hsmith, email=hsm@test.com, id=23312; name=Hannah Smith, username=hsmith, id=3223423, " +
                        "email=hsm@test.com; name=Robert M, username=rm44, id=222342, email=rm@me.com; name=Robert M," +
                        " username=rm4411, id=5535, email=rm@me.com; name=Susan Vee, username=sv55, id=443432," +
                        " email=susanv123@me.com; name=Robert Nick, username=rnick33, id=23432, email=" +
                        "rnick@gmail.com; name=Robert Nick II, username=rnickTemp34, id=23432, email=" +
                        "rnick@gmail.com; name=Susan Vee, username=sv55, id=443432, email=susanv123@me.com;"
            val s = log_dump.split(";").toMutableList()
            val newList: MutableList<String> = s.toMutableList()

            for (j in s.indices) {
                var user = s[j].substringAfter("username=").substringBefore(',')
                for (i in newList.indices) {
                    if (s[i].contains(user) && i > j) {
                        newList.removeAt(i)
                    }
                }
            }
            println(newList.size)
            return newList.toString()
        }

        fun LogDumpGetUnique(): String {

            var log_dump: String =
                "name=John Trust, username=john3, email=john3@gmail.com, id=434453; name=Hannah Smith, username=hsmith, email=hsm@test.com, id=23312; name=Hannah Smith, username=hsmith, id=3223423, email=hsm@test.com; name=Robert M, username=rm44, id=222342, email=rm@me.com; name=Robert M, username=rm4411, id=5535, email=rm@me.com; name=Susan Vee, username=sv55, id=443432, email=susanv123@me.com; name=Robert Nick, username=rnick33, id=23432, email=rnick@gmail.com; name=Robert Nick II, username=rnickTemp34, id=23432, email=rnick@gmail.com; name=Susan Vee, username=sv55, id=443432, email=susanv123@me.com;"

            val splitList = log_dump.split(";")

            var dupSplitList = splitList.toMutableList()

            for (i in splitList.indices) {
                var username = splitList[i].substringAfter("username=").substringBefore(',')
                val sub = splitList[i].removeSurrounding("id=", ",")
                for (j in dupSplitList.indices) {
                    if (splitList[j].contains(username) && j > i) {
                        dupSplitList.removeAt(j)
                    }
                }
            }

            for (i in splitList.indices) {
//                var id = splitList[i].substringAfter("id=").substringBefore(',')
//                println(id)
                var newS = splitList[i].replace("id=", "")
                println(newS)
            }

            val separator = ";"
            val string = dupSplitList.joinToString(separator)

            // code goes here
            return dupSplitList.toString();

        }


//        fun SnakeCase(str: String): String {
//
//            str.replace("/[^A-Za-z]/g", "_"])
//
//
//            str.replace("/^A-Za-z/g"," +")
//            str.replace(/[^A-Za-z/g, ' '])
//
//
//            // code goes here
//            return str;
//
//        }

    }


}