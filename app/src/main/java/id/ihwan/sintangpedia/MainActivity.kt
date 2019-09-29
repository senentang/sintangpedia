package id.ihwan.sintangpedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.databinding.DataBindingUtil.setContentView
import id.ihwan.sintangpedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivityMainBinding>(this, R.layout.activity_main)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getListPlace()

        viewModel.liveDataListPlace.observe(this, Observer {

        })


    }
}
