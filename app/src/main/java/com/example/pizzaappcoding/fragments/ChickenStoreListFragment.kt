package com.example.pizzaappcoding.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pizzaappcoding.R
import com.example.pizzaappcoding.ViewStoreDetailActivity
import com.example.pizzaappcoding.adapters.ChickenStoreAdapter
import com.example.pizzaappcoding.adapters.PizzaStoreAdapter
import com.example.pizzaappcoding.databinding.FragmentChickenStoreListBinding
import com.example.pizzaappcoding.databinding.FragmentPizzaStoreListBinding
import com.example.pizzaappcoding.datas.Store

class ChickenStoreListFragment : Fragment() {
    private var _binding: FragmentChickenStoreListBinding? = null
    private val binding get() = _binding!!

    val mChickenStoreDataList = ArrayList<Store>()
    lateinit var mChickenStoreAdapter: ChickenStoreAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChickenStoreListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mChickenStoreDataList.add(Store("A치킨가게", "1111-5555"    , ""))
        mChickenStoreDataList.add(Store("B치킨가게", "1111-5555", ""))
        mChickenStoreDataList.add(Store("C치킨가게", "1111-5555", ""))
        mChickenStoreDataList.add(Store("D치킨가게", "1111-5555", ""))

        mChickenStoreAdapter =
            ChickenStoreAdapter(requireContext(), R.layout.chicken_store_list_item, mChickenStoreDataList)

        // Set the adapter to the RecyclerView or ListView using View Binding
        binding.chickenListView.adapter = mChickenStoreAdapter

        binding.chickenListView.setOnItemClickListener{parent, view, position, id->

            val clickedStore= mChickenStoreDataList[position]
            val myIntent = Intent(requireContext(), ViewStoreDetailActivity::class.java)
            myIntent.putExtra("storeData", clickedStore)
            startActivity(myIntent)

        }    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
