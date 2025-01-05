package com.example.posdashboard.ui.components

import android.app.DatePickerDialog
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun TextFieldWithDatePicker(label: String, onDateSelected: (String) -> Unit) {
    var selectedDate by remember { mutableStateOf("") }
    val dateFormatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val today = Calendar.getInstance()
    val context = LocalContext.current


    Text(
        text = selectedDate.ifEmpty { label },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(4.dp))
            .clickable {
                try {
                    val datePicker = DatePickerDialog(
                        context,
                        { _, year, month, day ->
                            today.set(year, month, day)
                            selectedDate = dateFormatter.format(today.time)
                            onDateSelected(selectedDate)
                        },
                        today.get(Calendar.YEAR),
                        today.get(Calendar.MONTH),
                        today.get(Calendar.DAY_OF_MONTH)
                    )
                    datePicker.show()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            .padding(8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun TextFieldWithDatePickerPreview() {
    TextFieldWithDatePicker(label = "Select Date") { selectedDate ->

    }
}