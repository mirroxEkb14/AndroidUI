package com.amirovdev.swipetoaction.touch_helper

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.amirovdev.swipetoaction.adapter.MyAdapter
import java.util.*


class SimpleItemTouchHelperCallback(val adapter: MyAdapter) : ItemTouchHelper.Callback() {

    // Возвращает ответ, поддерживается ли Drag & Drop при долгом нажатии на элемент
    override fun isLongPressDragEnabled(): Boolean {
        //Drag & drop поддерживается
        return true
    }

    // Возвращает ответ, поддерживается ли жест Swipe
    override fun isItemViewSwipeEnabled(): Boolean {
        //Swipe поддерживается
        return true
    }

    // Возвращает флаги, которые отвечают за разрешенные направления движения Drag & Drop и Swipe жестов
    override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: ViewHolder): Int {
        //Настраиваем флаги для drag & drop и swipe жестов
        val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        val swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END
        return makeMovementFlags(dragFlags, swipeFlags)
    }

    // Вызывается, когда элементы перемещаются
    override fun onMove(recyclerView: RecyclerView, viewHolder: ViewHolder, target: ViewHolder): Boolean {
        val items = adapter.data
        val fromPosition = viewHolder.adapterPosition
        val toPosition = target.adapterPosition
        //Меняем элементы местами с помощью метода swap
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(items, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(items, i, i - 1)
            }
        }
        //Сообщаем об изменениях адаптеру
        //Or DiffUtil
        adapter.notifyItemMoved(fromPosition, toPosition)
        return true
    }

    // Вызывается, когда происходит Swipe жест.
    override fun onSwiped(viewHolder: ViewHolder, direction: Int) {
        //Удаляем элемент из списка после жеста swipe
        adapter.data.removeAt(viewHolder.adapterPosition)
        //Or DiffUtil
        adapter.notifyItemRemoved(viewHolder.adapterPosition);
    }
}