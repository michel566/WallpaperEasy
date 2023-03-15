package com.example.wallpapereasy.ui.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.wallpapereasy.R
import com.example.wallpapereasy.databinding.FragmentMainBinding
import com.example.wallpapereasy.ui.fragment.category.CategoriesFragment
import com.example.wallpapereasy.ui.fragment.collectons.CollectionFragment
import com.example.wallpapereasy.ui.fragment.pageradapter.ViewPagerAdapter
import com.example.wallpapereasy.ui.fragment.popular.PopularFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val tagTitle = listOf("Popular", "Collections", "Categories")
    private val fragments = listOf(PopularFragment(), CollectionFragment(), CategoriesFragment())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initViewPager()
        initTabLayout()
    }

    private fun initTabLayout() {
        TabLayoutMediator(binding.tabLayout,
            binding.viewPager) { tab, position ->

            tab.text = tagTitle[position]
        }.attach()
    }

    private fun initToolbar(){
        binding.toolbar.title = "Wallpapers"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
    }

    private fun initViewPager(){
        val pagerAdapter = ViewPagerAdapter(context as FragmentActivity, fragments)
        binding.run {
            viewPager.adapter = pagerAdapter
        }
    }

}