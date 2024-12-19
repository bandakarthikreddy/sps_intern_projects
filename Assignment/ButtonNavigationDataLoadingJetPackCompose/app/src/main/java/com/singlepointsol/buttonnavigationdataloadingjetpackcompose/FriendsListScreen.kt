package com.singlepointsol.buttonnavigationdataloadingjetpackcompose

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.database.*

@Composable
fun FriendsListScreen() {
    val friendsList = remember { mutableStateListOf<String>() }
    val database = FirebaseDatabase.getInstance().getReference("Friends")

    database.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            friendsList.clear()
            for (child in snapshot.children) {
                val friend = child.getValue(Friends::class.java)
                friend?.name?.let { friendsList.add(it) }
            }
        }

        override fun onCancelled(error: DatabaseError) {
            Log.e("Firebase", "Error: ${error.message}")
        }
    })

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        items(friendsList) { friendName ->
            Text(
                text = friendName,
                style = TextStyle(
                    color = Color.Red,
                    fontSize = 24.sp
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
