package `in`.tutorial.jetpacknavigation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import `in`.tutorial.jetpacknavigation.databinding.ItemDogBinding
import `in`.tutorial.jetpacknavigation.model.DogBreed

class DogsListAdapter(
    val dogsList:ArrayList<DogBreed>
):RecyclerView.Adapter<DogsListAdapter.MyViewHolder>() {
    fun updateDogList(newDogsList:List<DogBreed>){
        dogsList.clear()
        dogsList.addAll(newDogsList)
        notifyDataSetChanged()
    }
    class MyViewHolder(var binding:ItemDogBinding):RecyclerView.ViewHolder(binding.root){
        val tvName = binding?.name
        val lifespan = binding?.lifespan
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemDogBinding.inflate(
            LayoutInflater.from(parent.context),parent, false
        ))
    }

    override fun getItemCount() = dogsList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val model = dogsList[position]
        holder.tvName?.text = model.dogBreed
        holder.lifespan?.text = model.lifespan
        holder.itemView.setOnClickListener {
            Navigation.findNavController(it).navigate(ListFragmentDirections.actionDetailFragment())
        }
    }
}