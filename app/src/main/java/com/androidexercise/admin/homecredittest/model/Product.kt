package com.androidexercise.admin.homecredittest.model

data class Product(var section : String, var items : List<Items>, var section_title : String) {

    data class Items(var product_name : String, var product_image : String,
                     var link : String, var article_title : String, var article_image : String)
}