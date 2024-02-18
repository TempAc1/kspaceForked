package com.example.adminapp.AttendanceAct

class dataModel {
    private var pImg = 0
    private var pName: String? = null
    private var pRollNo: String? = null

    constructor() //no-args constructor
    constructor(pImg: Int, pName: String?, pRollNo: String?) {
        this.pImg = pImg
        this.pName = pName
        this.pRollNo = pRollNo
    }

    fun getpImg(): Int {
        return pImg
    }

    fun setpImg(pImg: Int) {
        this.pImg = pImg
    }

    fun getpName(): String? {
        return pName
    }

    fun setpName(pName: String?) {
        this.pName = pName
    }

    fun getpRollNo(): String? {
        return pRollNo
    }

    fun setpRollNo(pRollNo: String?) {
        this.pRollNo = pRollNo
    }
}
