package com.example.adminapp.GroupFragAdm

class dataModelRecVCourseSelectedFAdm {
    var chapterName: String? = null
    var totalNoOfModules = 0

    constructor() // no-args constructor
    constructor(chapterName: String?, totalNoOfModules: Int) {
        this.chapterName = chapterName
        this.totalNoOfModules = totalNoOfModules
    }

//    fun getChapterName() : String?{
//        return chapterName;
//    }
//
//    fun getTotalNoOfModules() : Int {
//        return totalNoOfModules;
//    }
//
//    fun setChapterName(chapterName: String?){
//        this.chapterName = chapterName;
//    }
//
//    fun setTotalNoOfModules(totalNoOfModules: Int){
//        this.totalNoOfModules = totalNoOfModules;
//    }
}
