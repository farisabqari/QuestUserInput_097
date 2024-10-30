package com.example.pratikum5

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MainScren(
    modifier: Modifier = Modifier
){

    var nama by rememberSaveable { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var noHP by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("")}

    val jenisKelamin = listOf("Laki-Laki", "Perempuan")
    var namaUser by rememberSaveable { mutableStateOf("") }
    var emailUser by remember { mutableStateOf("") }
    var alamatUser by remember { mutableStateOf("") }
    var noHPUser by remember { mutableStateOf("") }
    var selectedGenderUser by remember { mutableStateOf("")}


    Column (Modifier.fillMaxSize().padding(16.dp)
        , horizontalAlignment = Alignment.CenterHorizontally

    ){
        OutlinedTextField(value = nama,
            onValueChange = {nama = it},
            placeholder = { Text(text =  "Masukan Nama")
            }, modifier = Modifier.fillMaxWidth().padding(5.dp))

        Row {
            jenisKelamin.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    RadioButton(selected = selectedGender==item, onClick = {
                        selectedGender = item
                    })
                    Text(text = item)
                }
            }
        }

        OutlinedTextField(value = email,
            onValueChange = {email = it},
            placeholder = { Text(text =  "Masukan Email")
            }, modifier = Modifier.fillMaxWidth().padding(5.dp))

        OutlinedTextField(value = alamat,
            onValueChange = {alamat = it},
            placeholder = { Text(text =  "Masukan Alamat")
            }, modifier = Modifier.fillMaxWidth().padding(5.dp))

        OutlinedTextField(value = noHP,
            onValueChange = {noHP = it},
            placeholder = { Text(text =  "Masukan Nomor Handphone")
            }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(5.dp))

        Button(onClick = {
            namaUser = nama
            selectedGenderUser = selectedGender
            emailUser = email
            alamatUser = alamat
            noHPUser = noHP

        }) { Text("Simpan") }

        Card(modifier.size(height = 250.dp, width = 300.dp) ) {
            CardSection(judulParan = "Nama", isiParan = namaUser)
            CardSection(judulParan = "Jenis Kelamin", isiParan = selectedGenderUser)
            CardSection(judulParan = "Email", isiParan = emailUser)
            CardSection(judulParan = "Alamat", isiParan = noHPUser)



        }
    }
}
@Composable
fun CardSection(judulParan:String, isiParan:String) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = judulParan, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(text = "$isiParan", modifier = Modifier.weight(2f))
        }

    }
}