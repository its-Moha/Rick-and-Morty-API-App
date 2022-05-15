package com.example.rickandmortyapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmortyapp.databinding.ListItemBinding
import com.example.rickandmortyapp.model.Character

import retrofit2.Call

class RecyclerAdapter(private val context: Context, private val userList: List<Character>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var name = userList[position]
        holder.bind(name)

        holder.itemView.setOnClickListener {
            val intent = Intent(context,DetailsActivity::class.java)
            intent.putExtra(DetailsActivity.INTENT_PARCELABLE,name)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class ViewHolder(var listItemBinding: ListItemBinding): RecyclerView.ViewHolder(listItemBinding.root){

        fun bind(mydata: Character){
            listItemBinding.image.load(mydata.image)
            listItemBinding.name.text = (mydata.name)
//            listItemBinding.status.text = ("Status: ${mydata.status}")
//            listItemBinding.species.text = ("Species: ${mydata.species}")
//            listItemBinding.gender.text = ("Gender: ${mydata.gender}")
        }
    }



}