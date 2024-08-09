package com.semicolon.ttdpractice.leads

import org.junit.Assert.assertEquals

import org.junit.Test

class LeadsControllerTest {
    @Test
    fun `addLead() with valid data then lead has one item`() {
        // Given
        val leadsController = LeadsController()
        val lead = Lead("John", "Doe", "01123456789")
        // When
        leadsController.addLead(lead)
        // Then
        assert(leadsController.getLeads().size == 1)
    }

    @Test
    fun `addLead() with two char firstName then lead list is empty`() {
        // Given
        val leadsController = LeadsController()
        val lead = Lead("Jo", "Doe", "01123456789")
        // When
        leadsController.addLead(lead)
        // Then
        assertEquals(0,leadsController.getLeads().size )
    }
    @Test
    fun `addLead() with two char lastName then lead list is empty`() {
        // Given
        val leadsController = LeadsController()
        val lead = Lead("Joe", "Do", "01123456789")
        // When
        leadsController.addLead(lead)
        // Then
        assertEquals(0,leadsController.getLeads().size )
    }
    @Test
    fun `addLead() with invalid phone number len then lead list is empty`() {
        // Given
        val leadsController = LeadsController()
        val lead = Lead("Joe", "Doe", "0112345678")
        // When
        leadsController.addLead(lead)
        // Then
        assertEquals(0,leadsController.getLeads().size )
    }
    @Test
    fun `addLead() with invalid phone number config then lead list is empty`() {
        // Given
        val leadsController = LeadsController()
        val lead = Lead("Joe", "Doe", "0812345678")
        // When
        leadsController.addLead(lead)
        // Then
        assertEquals(0,leadsController.getLeads().size )
    }
    @Test
    fun `addLead() with invalid phone number char then lead list is empty`() {
        // Given
        val leadsController = LeadsController()
        val lead = Lead("Joe", "Doe", "ccccccccccc")
        // When
        leadsController.addLead(lead)
        // Then
        assertEquals(0,leadsController.getLeads().size )
    }
    @Test
    fun `addLead() with two same leads then lead list is one`() {
        // Given
        val leadsController = LeadsController()
        val lead = Lead("Joe", "Doe", "01123456789")
        // When
        leadsController.addLead(lead)
        leadsController.addLead(lead)
        // Then
        assertEquals(1,leadsController.getLeads().size )

    }
}