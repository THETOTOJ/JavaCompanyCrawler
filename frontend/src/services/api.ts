import axios from 'axios';

const API_BASE_URL = process.env.REACT_APP_API_URL || 'http://localhost:8080/api';

console.log('🌍 API Base URL:', API_BASE_URL);
console.log('🔧 Environment:', process.env.NODE_ENV);

export interface Company {
  id: number;
  name: string;
  registrationNumber: string;
  country: string;
  address: string;
  incorporationDate: string;
  status: 'ACTIVE' | 'DISSOLVED' | 'LIQUIDATION' | 'UNKNOWN';
  companyType: string;
  originalData: string;
}

export interface CrawlResponse {
  status: string;
  companiesCrawled: number;
  countries: string[];
  message: string;
}

export const api = {
  crawlCompanies: async (): Promise<CrawlResponse> => {
    const response = await axios.post(`${API_BASE_URL}/companies/crawl`);
    return response.data;
  },

  getAllCompanies: async (): Promise<Company[]> => {
    const response = await axios.get(`${API_BASE_URL}/companies`);
    return response.data;
  },

  searchCompanies: async (query: string): Promise<Company[]> => {
    const response = await axios.get(`${API_BASE_URL}/companies/search`, {
      params: { q: query }
    });
    return response.data;
  },

  getCompaniesByCountry: async (country: string): Promise<Company[]> => {
    const response = await axios.get(`${API_BASE_URL}/companies/country/${country}`);
    return response.data;
  }
};