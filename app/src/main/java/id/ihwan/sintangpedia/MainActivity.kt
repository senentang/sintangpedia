package id.ihwan.sintangpedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getListPlace()

        viewModel.liveDataListPlace.observe(this, Observer {
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
        })
    }
}
