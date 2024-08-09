package com.semicolon.ttdpractice.leads

class LeadsController {
    private val leadsList = mutableListOf<Lead>()
    fun addLead(lead: Lead) {
        if (isValidName(lead.firstName) && isValidName(lead.lastName)&& isValidPhoneNumber(lead.phoneNumber)) {
            if( leadsList.none { it.phoneNumber == lead.phoneNumber } ) {
            leadsList.add(lead)
            }
        }
    }
    fun getLeads(): List<Lead> {
        return leadsList
    }
    private fun isValidName(name: String): Boolean {
        return name.length > 2
    }
    private fun isValidPhoneNumber(phoneNumber: String): Boolean {
        return phoneNumber.length == 11 && phoneNumber.startsWith("01") && phoneNumber.all { it.isDigit() }
    }

}
