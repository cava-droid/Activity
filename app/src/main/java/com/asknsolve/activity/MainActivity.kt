package com.asknsolve.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.asknsolve.activity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if(resultCode == RESULT_OK){
//            when(requestCode){
//                99 -> {
//                    val message = data?.getStringExtra("returnValue")
//                    Toast.makeText(this,message,Toast.LENGTH_LONG).show()
//                }
//            }
//        }
//    }

    val getAction = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == RESULT_OK){
            // There are no request Codes
            val message = it.data?.getStringExtra("returnValue")
            Toast.makeText(this,message,Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = Intent(this, SubActivity::class.java)
        intent.putExtra("from1","Hello Bundle")
        intent.putExtra("from2", 2021)
        binding.btnStart.setOnClickListener {
//            startActivity(intent)
//          startActivityForResult(intent, 99)
            getAction.launch(intent)
        }

    }
}