package com.example.adminapp.mvc_posts_collections

class dataModelPostCollection {
    var postTitle: String? = null
    var postDesc: String? = null
    var postAttachments: String? = null
    var postTimestamp: String? = null
    var postAuthor: String? = null
    var instituteID: String? = null

    constructor()
    constructor(
        postTitle: String?,
        postDesc: String?,
        postAttachments: String?,
        postTimestamp: String?,
        postAuthor: String?,
        instituteID: String?
    ) {
        this.postTitle = postTitle
        this.postDesc = postDesc
        this.postAttachments = postAttachments
        this.postTimestamp = postTimestamp
        this.postAuthor = postAuthor
        this.instituteID = instituteID
    }

    override fun toString(): String {
        return "DataModelPostCollection{" +
                "title='" + postTitle + '\'' +
                ", description='" + postDesc + '\'' +
                ", author='" + postAuthor + '\'' +
                ", attachments ='" + postAttachments + '\'' +
                ", timestamp ='" + postTimestamp + '\'' +
                ", instituteID ='" + instituteID + '\'' +
                '}'
    }
}
