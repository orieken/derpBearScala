package com.derpbear

import java.util.Calendar

import faker._

case class User(id: Int, first_name: String, last_name: String, email: String, website: String, pet: String,
                created_at: java.util.Date, updated_at: java.util.Date)
