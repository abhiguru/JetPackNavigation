package `in`.tutorial.jetpacknavigation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import `in`.tutorial.jetpacknavigation.R
import `in`.tutorial.jetpacknavigation.databinding.FragmentListBinding
import `in`.tutorial.jetpacknavigation.viewmodel.ListViewModel

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {
    private lateinit var viewModel:ListViewModel
    private val dogsListAdapter:DogsListAdapter = DogsListAdapter(arrayListOf())

    var binding : FragmentListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)

        binding?.dogsList?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dogsListAdapter
        }
        observeViewModel()
        viewModel.refresh()
    }

    fun observeViewModel(){
        viewModel.dogs.observe(this, Observer {
            it?.let {
                binding?.dogsList?.visibility = View.VISIBLE
                dogsListAdapter.updateDogList(it)
                binding?.listError?.visibility = View.GONE
            }
        })
        viewModel.dogsLoadError.observe(this, Observer {
            it?.let{
                if(it) {
                    binding?.listError?.visibility = View.VISIBLE
                    binding?.dogsList?.visibility = View.GONE
                }else {
                    binding?.listError?.visibility = View.GONE
                }
            }
        })
        viewModel.loading.observe(this, Observer {
            it?.let {
                if(it)
                    binding?.loadingView?.visibility = View.VISIBLE
                else
                    binding?.loadingView?.visibility = View.GONE
                if(it) {
                    binding?.listError?.visibility = View.GONE
                    binding?.dogsList?.visibility = View.GONE
                }
            }
        })
    }

}