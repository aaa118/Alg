package com.company.general.kotlin.strings

class Strings {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val listOfPersons = mutableListOf<Person>()
            listOfPersons.add(Person("Hsatata", "Ytsti"))
            listOfPersons.add(Person("Ydarvva", "Hststs"))
            listOfPersons.add(Person("Wutstfdvf", "Eurstsrastf"))
            println(listOfPersons)
            println(sortListByLastName(listOfPersons))

//            for (i in 0 until nbr) {
//                for (j in i + 1 until nbr) {
//                    if (names.get(i).compareTo(names.get(j)) > 0) {
//                        tmp = names.get(i)
//                        names.get(i) = names.get(j)
//                        names.get(j) = tmp
//                    }
//                }
//            }
        }

        private fun sortListByLastName(listOfPersons: MutableList<Person>) {
//            var arry = listOfPersons
            var tmp: Person

            for (i in listOfPersons.indices) {
//                println(listOfPersons[i].last.toCharArray())

                for (j in i + 1 until listOfPersons.size) {
                    println(listOfPersons[i].last.compareTo(listOfPersons[j].last))
                    if (listOfPersons[i].last > listOfPersons[j].last) {
                        tmp = listOfPersons[i]
                        listOfPersons[i] = listOfPersons[j]
                        listOfPersons[j] = tmp
                    }
                }
            }
            println(listOfPersons)

        }


    }

    data class Person(val first: String, val last: String)

    class dsts {

    }
}