package gaur.himanshu.getstartedwithroom

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.mylayoutapp.R
import com.makeramen.roundedimageview.RoundedImageView

class CustomArrayAdapters(val activity: Activity, val list: List<OurData>) :
    ArrayAdapter<OurData>(activity, R.layout.list_items) {

    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val contexs = activity.layoutInflater
        val rowView = contexs.inflate(R.layout.list_items, null)

        val images = rowView.findViewById<RoundedImageView>(R.id.images)
        val title = rowView.findViewById<TextView>(R.id.title)
        val desc = rowView.findViewById<TextView>(R.id.desc)

        title.text = list[position].title
        desc.text = list[position].desc
        images.setImageResource(list[position].image)

        return rowView
    }
}