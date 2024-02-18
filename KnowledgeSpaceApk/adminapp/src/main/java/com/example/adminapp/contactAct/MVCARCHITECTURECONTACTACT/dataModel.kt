package com.example.adminapp.contactAct.MVCARCHITECTURECONTACTACT

class dataModel {
    var contactName: String? = null
    var number: String? = null
    var img = 0

    constructor() //empty constructor
    constructor(contactName: String?, number: String?, img: Int) {
        this.contactName = contactName
        this.number = number
        this.img = img
    }
}
