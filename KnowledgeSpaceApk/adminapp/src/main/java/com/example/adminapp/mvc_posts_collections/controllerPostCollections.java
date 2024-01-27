package com.example.adminapp.mvc_posts_collections;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class controllerPostCollections {
    private FirebaseFirestore db;
    private CollectionReference postsCollections;

    public interface FetchPostsCallback {
        void onPostsFetched(List<dataModelPostCollection> postList);
        void onFetchPostsFailure(Exception e);
    }

    public controllerPostCollections() {
        db = FirebaseFirestore.getInstance();
        postsCollections = db.collection("Posts");
    }

    public  void addPost(dataModelPostCollection newPost){
        postsCollections.add(newPost)
                .addOnSuccessListener(documentReference -> {
                    Log.i("DocAddedSuccess", "Document added successfully with id ->" + documentReference.getId());

                })
                .addOnFailureListener(e -> {
                    Log.i("DocFailure", "Document could not be added -> "+e);
                });
    }

    public void getPosts(FetchPostsCallback callback){
        postsCollections.get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    List<dataModelPostCollection> postList = new ArrayList<>();
                    for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                        dataModelPostCollection post = documentSnapshot.toObject(dataModelPostCollection.class);
                        postList.add(post);
                    }
                    callback.onPostsFetched(postList);
                })
                .addOnFailureListener(e -> {
                    Log.i("PostFetch", "Error fetching post : " + e);

                });
    }
}
