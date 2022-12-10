package com.route.basicsrecyclerview.kotlin

fun main() {
    var number1: Int = 5
    number1 = 8

    val number2 = 6
    val number3: Int? = null
    val number4: Int = number3 ?: 0

    add(number1, 50)
    number1 = number2
    add(5, 8)
    add(4, 6)

    val p = Person("Mohamed")
    val p2 = Person("Kareem")
    val p3: Person? = null // ? Nullable Types
    var myNumber: Int
    //Length of Name of the manager of the department
    val department: Department? = Department(null)
//    if (department != null &&
//        department.manager != null
//        && department.manager.name != null
//    )
    print(department?.manager?.name?.length) // ?. Conditional Access

    // ?: Elvis Operator
    print(department?.manager?.name ?: "Unknown Text")
    // Assert Not-Null
    print(department!!.manager!!.name!!)

    print(department.manager?.name)

    //Readability
    val developer: Developer = Developer(id = "28", name = "Mohamed")
    add(num1 = 50)
    add(num2 = 50, num1 = 15)
    add(num2 = 50, num1 = 15)
    add(50)
    add()
    //Less Function Overloading
    print(null)
    var settingsItem: SettingsItem = SettingsItem(
        "Wi-FI",
        "Description",
        50
    )
    settingsItem.imageResource = 100

    var batterySettings: SettingsItem = SettingsItem("Battery")
    val id = 50
    val name = "Kareem"
    val person = Person("Ahmed", 200)
    print("Hello There Your Id: " + id + "and your name: " + name)
    print("Hello There Your Id: $id and your name: ${person.name}")
}

data class SettingsItem(//data class
    private var title: String? = null,
    var description: String? = null,
    var imageResource: Int? = null
)


fun add(num1: Int = 0, num2: Int = 0): Int {
    return num1 + num2
}

class Department(var manager: Person?)


class Person(var name: String?, var id: Int) {

    constructor(name: String) : this(name, 0)

    constructor() : this("Unknown", 0)
}

open class Employee(var name: String, var id: String) {

}

class Developer(name: String, id: String) : Employee(name = name, id = id) {
}


//Private -> public getters & setters
//Public -> edit





