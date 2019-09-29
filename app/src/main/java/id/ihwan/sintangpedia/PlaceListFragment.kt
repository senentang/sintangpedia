package id.ihwan.sintangpedia


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ihwan.sintangpedia.databinding.FragmentPlaceListBinding
import id.ihwan.sintangpedia.adapters.PlaceAdapter

/**
 * A simple [Fragment] subclass.
 */
class PlaceListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPlaceListBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = PlaceAdapter()
        binding.placeList.adapter = adapter
        subscribeUi(adapter)

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun subscribeUi(adapter: PlaceAdapter) {

    }


}
