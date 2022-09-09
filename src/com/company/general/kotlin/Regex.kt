package com.company.general.kotlin

class Regex {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            //            println(log())

            "cats AND*Dogs-are Awesome"

            println(LogDumpGetUnique())

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