package com.example.criminalintent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.criminalintent.databinding.CrimeListItemBinding
import com.example.criminalintent.databinding.CrimeSeriousListItemBinding

class CrimeHolder(
    private val binding: CrimeListItemBinding
) : ViewHolder(binding.root) {
    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title
        binding.crimeDate.text = crime.formattedDate(crime.date)

        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context, "${crime.title}, clicked", Toast.LENGTH_SHORT)
                .show()
        }

        binding.icSolved.visibility = if (crime.isSolved) View.VISIBLE else View.GONE
    }
}

class CrimeHolderRequiresPolice(
    private val binding: CrimeSeriousListItemBinding
) : ViewHolder(binding.root) {
    fun bind(crime: Crime) {
        binding.crimeSeriousTitle.text = crime.title
        binding.crimeSeriousDate.text = crime.formattedDate(crime.date)

        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context, "${crime.title}, clicked", Toast.LENGTH_SHORT)
                .show()
        }
    }
}


class CrimeListAdapter(private val crimes: List<Crime>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return if (viewType == VIEW_CRIME) {
            val binding = CrimeListItemBinding.inflate(inflater, parent, false)

            CrimeHolder(binding)
        } else {
            val binding = CrimeSeriousListItemBinding.inflate(inflater, parent, false)

            CrimeHolderRequiresPolice(binding)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val crime = crimes[position]
        if (holder.itemViewType == VIEW_CRIME) {
            (holder as CrimeHolder).bind(crime)
        } else {
            (holder as CrimeHolderRequiresPolice).bind(crime)
        }
    }

    override fun getItemCount(): Int = crimes.size

    override fun getItemViewType(position: Int): Int {
        return if (crimes[position].requirePolice) VIEW_SERIOUS_CRIME else VIEW_CRIME
    }

    companion object {
        private const val VIEW_SERIOUS_CRIME = 1
        private const val VIEW_CRIME = 0
    }
}
