package com.game.testklassroom1.ui

import android.graphics.Rect
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.LineBackgroundSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.game.testklassroom1.R
import com.game.testklassroom1.databinding.FragmentMenuBinding
import com.game.testklassroom1.util.dp


class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding: FragmentMenuBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val exampleString = "Charlotte Perriand’s “La maison au bord de l’eau"

        val textView = binding.bottomTxt
        showBottomText(exampleString, textView)
    }


    private fun showBottomText(exampleString: String, textView: TextView) {
        val backgroundColor = resources.getColor(R.color.white)
        val spannableString = SpannableString(exampleString)
        val lineHeight = 60
        val backgroundSpan =
            LineBackgroundSpan { canvas, paint, left, right, top, baseline, bottom, text, start, end, lineNumber ->
                val paintColor: Int = paint.color
                val width = paint.measureText(spannableString, start, end)
                val newWidth = requireContext().dp(width.toInt())

                val bgRect = Rect(
                    left, top, newWidth.toInt(),
                    top + lineHeight
                )

                paint.setColor(backgroundColor)
                canvas.drawRect(bgRect, paint)
                paint.setColor(paintColor)
            }

        spannableString.setSpan(
            backgroundSpan,
            0,
            exampleString.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        textView.text = spannableString
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
