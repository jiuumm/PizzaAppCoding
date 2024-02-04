package com.example.pizzaappcoding.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pizzaappcoding.R
import com.example.pizzaappcoding.ViewStoreDetailActivity
import com.example.pizzaappcoding.adapters.PizzaStoreAdapter
import com.example.pizzaappcoding.databinding.FragmentPizzaStoreListBinding
import com.example.pizzaappcoding.datas.Store

class PizzaStoreListFragment : Fragment() {
    private var _binding: FragmentPizzaStoreListBinding? = null
    private val binding get() = _binding!!

    val mPizzaStoreDataList = ArrayList<Store>()
    lateinit var mPizzaStoreAdapter: PizzaStoreAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPizzaStoreListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mPizzaStoreDataList.add(Store("A피자가게", "1111-5555", "https://cdn3.iconfinder.com/data/icons/street-food-and-food-trucker-1/64/pizza-fast-food-bake-bread-128.png"))
        mPizzaStoreDataList.add(Store("B피자가게", "1111-5555", "https://cdn1.iconfinder.com/data/icons/cartoon-snack/128/pizza-128.png"))
        mPizzaStoreDataList.add(Store("C피자가게", "1111-5555", "https://cdn3.iconfinder.com/data/icons/food-set-3/91/Food_C219-128.png"))
        mPizzaStoreDataList.add(Store("D피자가게", "1111-5555", "https://cdn0.iconfinder.com/data/icons/fastfood-31/64/pizza-italian-food-fast-fastfood-cheese-piece-128.png"))

        mPizzaStoreAdapter =
            PizzaStoreAdapter(requireContext(), R.layout.pizza_store_list_item, mPizzaStoreDataList)

        // Set the adapter to the RecyclerView or ListView using View Binding
        binding.pizzaStoreListView.adapter = mPizzaStoreAdapter

        binding.pizzaStoreListView.setOnItemClickListener{parent, view, position, id->

            val clickedStore= mPizzaStoreDataList[position]
            val myIntent = Intent(requireContext(), ViewStoreDetailActivity::class.java)
            myIntent.putExtra("storeData", clickedStore)
            startActivity(myIntent)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
