package com.example.rickandmortyapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmortyapp.databinding.ActivityMainBinding
import com.example.rickandmortyapp.model.Character
import com.example.rickandmortyapp.modelView.CharacterViewModel
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(){

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: RecyclerAdapter
    lateinit var characterViewModel: CharacterViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getCharacter()
    }

    fun getCharacter() {

        //initialize viewModel
        characterViewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)

        //call api from viewModel
        characterViewModel.getData()

        //get liveData observer
        characterViewModel.characterLiveData.observe(this, Observer {
            initAdapter(it)
        })
    }

    private fun initAdapter(state: ScreenState<List<Character>>) {

        when (state) {
            is ScreenState.Loading -> {
                binding.progressBar.visibility = View.VISIBLE
            }
            is ScreenState.Success -> {
                binding.progressBar.visibility = View.GONE
                if (state.data != null) {
                    adapter = RecyclerAdapter(this,state.data)
                    binding.recyclerView.adapter = adapter
                    adapter.notifyDataSetChanged()
                }
            }
            is ScreenState.Error -> {
                binding.progressBar.visibility = View.GONE
                val view = binding.progressBar.rootView
                Snackbar.make(view,state.message!!,Snackbar.LENGTH_SHORT).show()

            }
        }

    }



    //   lateinit var userList: MutableList<Character>
    //  lateinit var charList: MutableList<Character>
    //    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.main_menu,menu)
//        var item: MenuItem = menu!!.findItem(R.id.search)
//
//        if (item !=null){
//            var searchView = item.actionView as SearchView
//
//            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//                override fun onQueryTextSubmit(query: String?): Boolean {
//                    return true
//                }
//
//                override fun onQueryTextChange(newText: String?): Boolean {
//                    if (newText!!.isNotEmpty()) {
//                        userList.clear()
//                        var search = newText.lowercase(Locale.getDefault())
//                        for (character in charList) {
//                            if (character.lowercase(Locale.getDefault()).contains(search))
//                                userList.add(charList)
//                        }
//
//                        binding.recyclerView.adapter!!.notifyDataSetChanged()
//                    }
//                    else{
//                        userList.clear()
//                        userList.addAll(charList)
//                        binding.recyclerView.adapter!!.notifyDataSetChanged()
//                    }
//                    return true
//                }
//            })
//        }
//
//        return super.onCreateOptionsMenu(menu)
//
//    }
}

