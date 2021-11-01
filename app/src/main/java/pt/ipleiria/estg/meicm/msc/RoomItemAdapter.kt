package pt.ipleiria.estg.meicm.msc

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class RoomItemAdapter(private val dataSet: LinkedList<Room>, private val clicked: MutableLiveData<Pair<Int, Room>>) :
        RecyclerView.Adapter<RoomItemAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val roomName: TextView = view.findViewById(R.id.lb_room_name)
        val ip: TextView = view.findViewById(R.id.lb_ip)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.room_item_recyclerview, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.roomName.text = dataSet[position].roomName.capitalize(Locale.ROOT)
        viewHolder.ip.text = dataSet[position].ip
        clicked.postValue(Pair(-1, dataSet[position]))
        viewHolder.itemView.setOnClickListener {
            viewHolder.itemView.setBackgroundColor(Color.LTGRAY)
            clicked.postValue(Pair(position, dataSet[position]))
        }


    }

    override fun getItemCount() = dataSet.size

}
