export interface deliveriesCompanies {
    delivery_company_id: number,
    business_name: string,
    tax_number: number,
    frequency_rate: string
}

export interface menuprimeLocations {
    menuprime_location_id: number,
    name: string,
    address: string,
    city: string,
    department: string
}

export interface availableFields {
    available_field_id: number,
    table_name: string,
    column_name: string
}

export interface fileStructure {
    file_structure_id?: number,
    fk_available_field_id: number,
    fk_location_id: number,
    fk_delivery_company_id: number
}

export interface months {
    name: string,
    number: string    
}
