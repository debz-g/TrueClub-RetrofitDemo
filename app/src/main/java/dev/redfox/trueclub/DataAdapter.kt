package dev.redfox.trueclub

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.redfox.trueclub.databinding.DataListItemBinding
import dev.redfox.trueclub.models.Country
import dev.redfox.trueclub.models.DataModel

class DataAdapter(
    val context: Context,
    val dataList: MutableList<Country>
) : RecyclerView.Adapter<DataAdapter.MainViewHolder>() {

    class MainViewHolder(val binding: DataListItemBinding):
            RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataListItemBinding.inflate(layoutInflater, parent, false)

        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = dataList[position]

        holder.binding.apply {
            tvCountry.text = "Country: " + data.country_id
            tvProb.text = "Probability: " + data.probability.toString()
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}