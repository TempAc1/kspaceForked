package com.example.adminapp.UsersCommentScAdm

class dataModelUsersCommentScAdm {
    private var cId: String? = null
    var comment: String? = null
    var ptime: String? = null
    var udp: String? = null
    var uemail: String? = null
    var uid: String? = null
    var uname: String? = null


//    fun getcId(): String? {
//        return cId
//    }
//
//    fun setcId(cId: String?) {
//        this.cId = cId
//    }



    constructor()



    constructor(
        cId: String?,
        comment: String?,
        ptime: String?,
        udp: String?,
        uemail: String?,
        uid: String?,
        uname: String?
    ) {
        this.cId = cId
        this.comment = comment
        this.ptime = ptime
        this.udp = udp
        this.uemail = uemail
        this.uid = uid
        this.uname = uname
    }



//    // Getter for udp
//    fun getUdp(): String? {
//        return udp
//    }
//
//    // Setter for udp
//    fun setUdp(udp: String?) {
//        this.udp = udp
//    }
//
//    // Getter for ptime
//    fun getPtime(): String? {
//        return ptime
//    }
//
//    // Setter for ptime
//    fun setPtime(ptime: String?) {
//        this.ptime = ptime
//    }
//
//    // Getter for comment
//    fun getComment(): String? {
//        return comment
//    }
//
//    // Setter for comment
//    fun setComment(comment: String?) {
//        this.comment = comment
//    }
//
//    // Getter for cId
//    fun getCId(): String? {
//        return cId
//    }
//
//    // Setter for cId
//    fun setCId(cId: Int) {
//        this.cId = cId.toString()
//    }
//
//
//    // Getter and Setter for uemail
//    fun getUemail(): String? {
//        return uemail
//    }
//
//    fun setUemail(uemail: String?) {
//        this.uemail = uemail
//    }
//
//    // Getter and Setter for uid
//    fun getUid(): String? {
//        return uid
//    }
//
//    fun setUid(uid: String?) {
//        this.uid = uid
//    }
//
//
//    // Getter method for uname
//    fun getUname(): String? {
//        return uname
//    }
//
//    // Setter method for uname
//    fun setUname(uname: String?) {
//        this.uname = uname
//    }
}
