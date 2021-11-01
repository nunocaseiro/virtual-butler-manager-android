package pt.ipleiria.estg.meicm.msc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import pt.ipleiria.estg.meicm.msc.databinding.AddRoomBinding
import java.util.*

class AddRoomDialog(private val callback: UtilCallback, private val rooms: LinkedList<String>) : DialogFragment() {
    @ExperimentalStdlibApi
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<AddRoomBinding>(inflater, R.layout.add_room, container, false)
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.round_corner)

        val adapter = context?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item, rooms) }
        binding.spinnerRoomName.adapter = adapter

        binding.btnCreate.setOnClickListener {
            if (binding.spinnerRoomName.selectedItemPosition >= 0) {
                val room = Room(binding.spinnerRoomName.selectedItem.toString().lowercase(), binding.etIp.text.toString())
                callback.saveRoom(room)
            }
            this.dismiss()
        }

        binding.btnDismiss.setOnClickListener {
            this.dismiss()
        }

        return binding.root
    }


    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

}