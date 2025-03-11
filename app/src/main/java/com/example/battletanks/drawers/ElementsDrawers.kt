package com.example.battletanks.drawers

import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView // Исправлен импорт
import com.example.battletanks.CELL_SIZE
import com.example.battletanks.R
import com.example.battletanks.enums.Material
import com.example.battletanks.models.Coordinate

class ElementsDrawer(private val container: FrameLayout){
    var currentMaterial = Material.EMPTY

    fun drawView(coordinate: Coordinate) {
        // Пропускаем отрисовку если материал пустой
        if (currentMaterial == Material.EMPTY) return

        val view = ImageView(container.context) // Добавлен знак =
        val layoutParams = FrameLayout.LayoutParams(CELL_SIZE, CELL_SIZE)

        when (currentMaterial) { // Исправлена опечатка в currentMaterial
            Material.EMPTY ->{

            }
            Material.BRICK -> view.setImageResource(R.drawable.brick)
            Material.CONCRETE -> view.setImageResource(R.drawable.concrete)
            Material.GRASS -> view.setImageResource(R.drawable.grass) // Исправлено имя ресурса

        }

        // Установка координат (предполагается, что coordinate в пикселях)
        layoutParams.topMargin = coordinate.top // Исправлено присваивание
        layoutParams.leftMargin = coordinate.left

        view.layoutParams = layoutParams // Исправлено обращение
        view.id = View.generateViewId()

        container.addView(view)
    }
}