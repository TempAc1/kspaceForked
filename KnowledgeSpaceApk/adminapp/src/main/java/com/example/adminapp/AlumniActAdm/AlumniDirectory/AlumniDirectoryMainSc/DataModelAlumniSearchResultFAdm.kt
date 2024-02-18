package com.example.adminapp.AlumniActAdm.AlumniDirectory.AlumniDirectoryMainSc

class DataModelAlumniSearchResultFAdm {
    var tVNameAlumniSearchResultFAdm: String? = null
    var tVBatchYrAlumniSearchResultFAdm: String? = null
    var tVRegNoAlumniSearchResultFAdm: String? = null
    var tVDeptNameAlumniSearchResultFAdm: String? = null
    var linkedInImgVSingleResDesAlumniSearchFAdm = 0
    var personImgVAlumniSearchResultFAdm = 0

    constructor()
    constructor(
        tVNameAlumniSearchResultFAdm: String?,
        tVBatchYrAlumniSearchResultFAdm: String?,
        tVRegNoAlumniSearchResultFAdm: String?,
        tVDeptNameAlumniSearchResultFAdm: String?,
        linkedInImgVSingleResDesAlumniSearchFAdm: Int,
        personImgVAlumniSearchResultFAdm: Int
    ) {
        this.tVNameAlumniSearchResultFAdm = tVNameAlumniSearchResultFAdm
        this.tVBatchYrAlumniSearchResultFAdm = tVBatchYrAlumniSearchResultFAdm
        this.tVRegNoAlumniSearchResultFAdm = tVRegNoAlumniSearchResultFAdm
        this.tVDeptNameAlumniSearchResultFAdm = tVDeptNameAlumniSearchResultFAdm
        this.linkedInImgVSingleResDesAlumniSearchFAdm = linkedInImgVSingleResDesAlumniSearchFAdm
        this.personImgVAlumniSearchResultFAdm = personImgVAlumniSearchResultFAdm
    }


    fun gettVNameAlumniSearchResultFAdm(): String? {
        return tVNameAlumniSearchResultFAdm
    }

    fun settVNameAlumniSearchResultFAdm(tVNameAlumniSearchResultFAdm: String?) {
        this.tVNameAlumniSearchResultFAdm = tVNameAlumniSearchResultFAdm
    }

    fun gettVBatchYrAlumniSearchResultFAdm(): String? {
        return tVBatchYrAlumniSearchResultFAdm
    }

    fun settVBatchYrAlumniSearchResultFAdm(tVBatchYrAlumniSearchResultFAdm: String?) {
        this.tVBatchYrAlumniSearchResultFAdm = tVBatchYrAlumniSearchResultFAdm
    }

    fun gettVRegNoAlumniSearchResultFAdm(): String? {
        return tVRegNoAlumniSearchResultFAdm
    }

    fun settVRegNoAlumniSearchResultFAdm(tVRegNoAlumniSearchResultFAdm: String?) {
        this.tVRegNoAlumniSearchResultFAdm = tVRegNoAlumniSearchResultFAdm
    }

    fun gettVDeptNameAlumniSearchResultFAdm(): String? {
        return tVDeptNameAlumniSearchResultFAdm
    }

    fun settVDeptNameAlumniSearchResultFAdm(tVDeptNameAlumniSearchResultFAdm: String?) {
        this.tVDeptNameAlumniSearchResultFAdm = tVDeptNameAlumniSearchResultFAdm
    }
}
