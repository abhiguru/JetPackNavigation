package `in`.tutorial.jetpacknavigation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import `in`.tutorial.jetpacknavigation.R
import `in`.tutorial.jetpacknavigation.databinding.FragmentListBinding

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {

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
        binding?.buttonDetails?.setOnClickListener {
            val action = ListFragmentDirections.actionDetailFragment()
            action.dogUUID = 12
            Navigation.findNavController(it).navigate(action)
        }
    }
}