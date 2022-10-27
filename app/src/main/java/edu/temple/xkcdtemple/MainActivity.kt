package edu.temple.xkcdtemple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var titleTextView: TextView
    lateinit var altTextTextView: TextView
    lateinit var comicNumberEditText: EditText
    lateinit var loadComicButton: Button
    lateinit var comicDisplayImageView: ImageView
	
	lateinit var requestQueue : RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
		
		requestQueue = Volley.newRequestQueue(this)

        titleTextView = findViewById(R.id.titleTextView)
        altTextTextView = findViewById(R.id.altTextTextView)
        comicNumberEditText = findViewById(R.id.comicNumberEditText)
        loadComicButton = findViewById(R.id.loadComicButton)
        comicDisplayImageView = findViewById(R.id.comicDisplayImageView)
		
		loadComicButton.setOnClickListener {
			val comicNumber = comicNumberEditText.text.toString()
			val uri = URI("https://xkcd.com/$comicNumber/info.0.json")

            requestQueue.add(
                JsonObjectRequest(Request.Method.GET, uri.toString(), null, {
                    Log.d("Response", it.toString())
                }, {})
            )
		}
    }
}