package com.loan555.qlsinhvien_learnkotlin

class Student {
    private var name: String = ""
    private var birth: Int = 0
    private var phone: String = ""
    private var specialized: String = ""
    private var isUnivesity: Boolean = true

    constructor()
    constructor(name: String, birth: Int, phone: String, spe: String, isUni: Boolean) {
        this.name = name
        this.birth = birth
        this.phone = phone
        this.specialized = spe
        this.isUnivesity = isUni
    }

    //    -get set
    fun getName(): String {
        return this.name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getBirth(): Int {
        return birth
    }

    fun setBirth(birth: Int) {
        this.birth = birth
    }

    fun getPhone(): String {
        return phone
    }

    fun setPhone(phone: String) {
        this.phone = phone
    }

    fun getSpecialized(): String {
        return specialized
    }

    fun setSpecialized(spe: String) {
        this.specialized = spe
    }

    fun getIsUniversity(): Boolean {
        return isUnivesity
    }

    fun setIsUniversity(isUni: Boolean) {
        this.isUnivesity = isUni
    }

    override fun toString(): String {
        var education = ""
        if (this.getIsUniversity()) {
            education = "University"
        } else {
            education = "College"
        }
        return this.getName() + " | " + this.getBirth() + " | " + this.getPhone() + " | " + this.getSpecialized() + " | " + education
    }

}