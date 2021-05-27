package com.example.DataModel
public class DataCenter {

    var  arrayList: ArrayList<ItemsDataModel> = ArrayList<ItemsDataModel>()
    private   var instance: DataCenter? = null

    companion object {
        val instance = DataCenter()
    }
}