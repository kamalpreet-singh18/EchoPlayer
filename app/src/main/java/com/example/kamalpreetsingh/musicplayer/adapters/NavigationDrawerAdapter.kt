package com.example.kamalpreetsingh.musicplayer.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.kamalpreetsingh.musicplayer.R
import com.example.kamalpreetsingh.musicplayer.activities.MainActivity
import com.example.kamalpreetsingh.musicplayer.fragments.AboutUsFragment
import com.example.kamalpreetsingh.musicplayer.fragments.FavouritesFragment
import com.example.kamalpreetsingh.musicplayer.fragments.MainScreenFragment
import com.example.kamalpreetsingh.musicplayer.fragments.SettingFragment

/**
 * Created by Kamalpreet singh on 12-06-2018.
 */
class NavigationDrawerAdapter(_contentList: ArrayList<String>,_getImages: IntArray,_context: Context): RecyclerView.Adapter<NavigationDrawerAdapter.NavViewHolder>(){
    var contentList: ArrayList<String>?=null
    var getImages: IntArray?=null
    var mContext: Context?=null

    init{
        this.contentList=_contentList
        this.getImages=_getImages
        this.mContext=_context
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NavViewHolder{
        var itemView= LayoutInflater.from(parent?.context)
                .inflate(R.layout.row_custom_navigationdrawer,parent,false)
        val returnThis= NavViewHolder(itemView)
        return returnThis
    }

    override fun onBindViewHolder(holder: NavViewHolder?, position: Int) {
        holder?.get_Icon?.setBackgroundResource(getImages?.get(position) as Int)
        holder?.get_Text?.setText(contentList?.get(position))
        holder?.contentHolder?.setOnClickListener({
            if(position==0){
                val mainScreenFragment = MainScreenFragment()
                (mContext as MainActivity).supportFragmentManager
                        .beginTransaction().replace(R.id.details_fragment,mainScreenFragment).commit()
            }
            else{
                if(position==1){
                    val favouriteFragment= FavouritesFragment()
                    (mContext as MainActivity).supportFragmentManager
                            .beginTransaction().replace(R.id.details_fragment,favouriteFragment).commit()
                }
                else{
                    if(position==2){
                        val settingFragment = SettingFragment()
                        (mContext as MainActivity).supportFragmentManager
                                .beginTransaction().replace(R.id.details_fragment,settingFragment).commit()
                    }
                    else {
                        val aboutUsFragment = AboutUsFragment()
                        (mContext as MainActivity).supportFragmentManager
                                .beginTransaction().replace(R.id.details_fragment,aboutUsFragment).commit()
                    }
                }
            }
            MainActivity.Statified.drawerLayout?.closeDrawers()
        })
    }

    override fun getItemCount(): Int {
        return contentList?.size as Int
    }

    class NavViewHolder(itemview: View?): RecyclerView.ViewHolder(itemview){
        var get_Icon: ImageView?=null
        var get_Text: TextView?=null
        var contentHolder: RelativeLayout?=null
        init{
            get_Icon=itemview?.findViewById(R.id.icon_nav)
            get_Text=itemview?.findViewById(R.id.icon_name)
            contentHolder=itemview?.findViewById(R.id.navdrawer_item_content_holder)
        }
    }
}