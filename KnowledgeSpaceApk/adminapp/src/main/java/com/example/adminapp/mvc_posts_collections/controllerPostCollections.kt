package com.example.adminapp.mvc_posts_collections

import android.util.Log
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class controllerPostCollections {
    private val db: FirebaseFirestore
    private val postsCollections: CollectionReference

    interface FetchPostsCallback {
        fun onPostsFetched(postList: List<dataModelPostCollection>?)
        fun onFetchPostsFailure(e: Exception?)
    }

    init {
        db = FirebaseFirestore.getInstance()
        postsCollections = db.collection("Posts")
    }

    fun addPost(newPost: dataModelPostCollection?) {
        postsCollections.add(newPost!!)
            .addOnSuccessListener { documentReference: DocumentReference ->
                Log.i(
                    "DocAddedSuccess",
                    "Document added successfully with id ->" + documentReference.id
                )
            }
            .addOnFailureListener { e: Exception ->
                Log.i(
                    "DocFailure",
                    "Document could not be added -> $e"
                )
            }
    }

    fun getPosts(callback: FetchPostsCallback) {
        postsCollections.get()
            .addOnSuccessListener { queryDocumentSnapshots: QuerySnapshot ->
                val postList: MutableList<dataModelPostCollection> = ArrayList()
                for (documentSnapshot in queryDocumentSnapshots) {
                    val post = documentSnapshot.toObject(
                        dataModelPostCollection::class.java
                    )
                    postList.add(post)
                }
                callback.onPostsFetched(postList)
            }
            .addOnFailureListener { e: Exception -> Log.i("PostFetch", "Error fetching post : $e") }
    }
}
