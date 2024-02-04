package com.example.pizzaappcoding

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.pizzaappcoding.datas.Store
import com.example.pizzaappcoding.databinding.ActivityViewStoreDetailBinding
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermissionActivity
import com.gun0912.tedpermission.normal.TedPermission

class ViewStoreDetailActivity : BasicActivity() {

    lateinit var mStoreData: Store
    private lateinit var binding: ActivityViewStoreDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewStoreDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setValues()
        setupEvents()
    }

    override fun setupEvents() {
        // Your event setup code here
        //전화걸기 버튼 누르면-> 전화걸기시도 : 권한 문제 해결해야함
        binding.callPhoneBtn.setOnClickListener {

            val permissionListener = object : PermissionListener {
                override fun onPermissionGranted() {
                    val myUri = Uri.parse("tel:${mStoreData.phoneNum}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext, "전화연결권한 없음", Toast.LENGTH_SHORT).show()
                }

            }
            TedPermission.create()
                .setPermissionListener(permissionListener)
                .setDeniedMessage("[설정]에서 전화 권한을 켜주세요")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()

        }


    }
    override fun setValues() {
        mStoreData = intent.getSerializableExtra("storeData") as Store
        Glide.with(mContext).load(mStoreData.logoURL).into(binding.storeLogoImg) // Assuming you have an ImageView with the id "imageView" in your layout
        binding.storePhoneNumTxt.text=mStoreData.phoneNum
        binding.storeNameTxt.text= mStoreData.name

    }
}
