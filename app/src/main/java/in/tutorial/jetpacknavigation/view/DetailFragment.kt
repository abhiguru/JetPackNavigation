package `in`.tutorial.jetpacknavigation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import `in`.tutorial.jetpacknavigation.R
import `in`.tutorial.jetpacknavigation.databinding.FragmentDetailBinding
import `in`.tutorial.jetpacknavigation.viewmodel.DetailsViewModel

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    private var dogUUID = 0
    private lateinit var viewModel:DetailsViewModel

    var binding: FragmentDetailBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            dogUUID = DetailFragmentArgs.fromBundle(it).dogUUID
        }
        viewModel = ViewModelProviders.of(this).get(DetailsViewModel::class.java)
        viewModel.fetch()
        obervers()

    }
    fun obervers(){
        viewModel.dogDetails.observe(this, Observer {
            it?.let {
                binding?.dogName?.text = it.dogBreed.toString()
                binding?.dogLifespan?.text = it.lifespan.toString()
                binding?.dogTemperment?.text = it.temperament.toString()
                binding?.dogPurpose?.text = it.bredFor.toString()
            }
        })
    }
}