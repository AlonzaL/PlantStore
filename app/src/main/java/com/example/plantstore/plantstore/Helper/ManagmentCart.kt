package com.example.plantstore.plantstore.Helper

import android.content.Context
import android.widget.Toast
import com.example.plantstore.plantstore.Domain.PlantModel


class ManagmentCart(val context: Context) {

    private val tinyDB = TinyDB(context)

    fun insertItem(item: PlantModel) {
        var listPlant = getListCart()
        val existAlready = listPlant.any { it.Title == item.Title }
        val index = listPlant.indexOfFirst { it.Title == item.Title }

        if (existAlready) {
            listPlant[index].numberInCart = item.numberInCart
        } else {
            listPlant.add(item)
        }
        tinyDB.putListObject("CartList", listPlant)
        Toast.makeText(context, "Added to your Cart", Toast.LENGTH_SHORT).show()
    }

    fun getListCart(): ArrayList<PlantModel> {
        return tinyDB.getListObject("CartList") ?: arrayListOf()
    }

    fun minusItem(listFood: ArrayList<PlantModel>, position: Int, listener: ChangeNumberItemsListener) {
        if (position < 0 || position >= listFood.size) return
        val currentCount = listFood[position].numberInCart
        if (currentCount <= 1) {
            listFood.removeAt(position)
        } else {
            listFood[position].numberInCart = currentCount - 1
        }
        tinyDB.putListObject("CartList", listFood)
        listener.onChanged()
    }

    fun plusItem(listFood: ArrayList<PlantModel>, position: Int, listener: ChangeNumberItemsListener) {
        listFood[position].numberInCart++
        tinyDB.putListObject("CartList", listFood)
        listener.onChanged()
    }

    fun getTotalFee(): Double {
        val listFood = getListCart()
        var fee = 0.0
        for (item in listFood) {
            fee += item.Price * item.numberInCart
        }
        return fee
    }
}