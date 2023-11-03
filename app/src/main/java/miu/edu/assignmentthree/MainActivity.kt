package miu.edu.assignmentthree

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.setPadding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val table = findViewById<TableLayout>(R.id.table)
        val button = findViewById<Button>(R.id.addButton)
        val name = findViewById<EditText>(R.id.inputName)
        val version = findViewById<EditText>(R.id.inputVersion)

        button.setOnClickListener {
            if (name.text.toString().isNotEmpty() && version.text.toString().isNotEmpty()) {
                val row = createRow(this, name.text.toString(), version.text.toString())
                table.addView(row) // add row
                reset(listOf(name, version)) // reset inputs' text
                Toast.makeText(this, "Item is added to layout!", Toast.LENGTH_SHORT).show()
                name.requestFocus() // focus goes back to name field
            } else {
                Toast.makeText(this, "Inputs must be filled!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun reset(inputs: List<EditText>) {
        inputs.forEach {it
            it.text.clear()
        }
    }

    private fun createRow(context: Context, name: String, version: String): TableRow {
        val row = TableRow(context)
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT)
        row.layoutParams = layoutParams
        row.setPadding(12)
        row.addView(createTextView(context, name))
        row.addView(createTextView(context, version))
        return row;
    }

    private fun createTextView(context: Context, text: String): TextView {
        val view = TextView(context)
        view.text = text
        return view
    }
}