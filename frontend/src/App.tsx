import React, { useState, useEffect } from 'react';
import {
  Container,
  Header,
  Button,
  Input,
  Dropdown,
  Message,
  Loader,
  Divider,
  Card,
  Icon,
  Menu
} from 'semantic-ui-react';
import { api, Company } from './services/api';
import { CompanyCard } from './components/CompanyCard';
import { Statistics } from './components/Statistics';
import './App.css';

const countryOptions = [
  { key: 'all', text: 'All Countries', value: 'ALL' },
  { key: 'uk', text: '🇬🇧 United Kingdom', value: 'UK' },
  { key: 'fr', text: '🇫🇷 France', value: 'FRANCE' },
  { key: 'de', text: '🇩🇪 Germany', value: 'GERMANY' }
];

function App() {
  const [companies, setCompanies] = useState<Company[]>([]);
  const [filteredCompanies, setFilteredCompanies] = useState<Company[]>([]);
  const [loading, setLoading] = useState(false);
  const [searchQuery, setSearchQuery] = useState('');
  const [selectedCountry, setSelectedCountry] = useState('ALL');
  const [message, setMessage] = useState<{ type: 'success' | 'error' | 'info', text: string } | null>(null);
  const [crawled, setCrawled] = useState(false);

  useEffect(() => {
    filterCompanies();
  }, [companies, searchQuery, selectedCountry]);

  const filterCompanies = () => {
    let filtered = companies;

    // Filter by search query
    if (searchQuery) {
      filtered = filtered.filter(c =>
        c.name.toLowerCase().includes(searchQuery.toLowerCase()) ||
        c.registrationNumber.toLowerCase().includes(searchQuery.toLowerCase())
      );
    }

    // Filter by country
    if (selectedCountry !== 'ALL') {
      filtered = filtered.filter(c => c.country === selectedCountry);
    }

    setFilteredCompanies(filtered);
  };

  const handleCrawl = async () => {
    setLoading(true);
    setMessage({
      type: 'info',
      text: '⏳ Waking up backend server... This may take up to 60 seconds on the first request (free tier limitation).'
    });
    
    try {
      console.log('🚀 Starting crawl...');
      const response = await api.crawlCompanies();
      console.log('✅ Crawl Response:', response);
      
      const allCompanies = await api.getAllCompanies();
      console.log('✅ All Companies:', allCompanies);
      
      setCompanies(allCompanies);
      setCrawled(true);
      setMessage({
        type: 'success',
        text: `✅ ${response.message} (${response.companiesCrawled} companies loaded)`
      });
    } catch (error: any) {
      console.error('❌ Error during API call:', error);
      
      let errorMessage = '❌ Failed to crawl companies. ';
      
      if (error.code === 'ECONNABORTED') {
        errorMessage += '⏱️ Request timed out. The backend server is taking too long to wake up. Please try again in a moment.';
      } else if (error.response) {
        errorMessage += `Server error: ${error.response.status} - ${error.response.data?.message || 'Unknown error'}`;
      } else if (error.request) {
        errorMessage += '🌐 No response from server. Please check if the backend is running.';
      } else {
        errorMessage += `Error: ${error.message}`;
      }
      
      setMessage({
        type: 'error',
        text: errorMessage
      });
    } finally {
      setLoading(false);
    }
  };

  const handleSearch = (value: string) => {
    setSearchQuery(value);
  };

  const handleCountryChange = (value: any) => {
    setSelectedCountry(value);
  };

  return (
    <div className="App">
      <Menu fixed='top' inverted>
        <Container>
          <Menu.Item header>
            <Icon name='world' />
            European Company Crawler
          </Menu.Item>
          <Menu.Menu position='right'>
            <Menu.Item>
              <Icon name='github' />
              <a 
                href="https://github.com/THETOTOJ/JavaCompanyCrawler" 
                target="_blank" 
                rel="noopener noreferrer"
                style={{ color: 'white', marginLeft: '0.5em' }}
              >
                GitHub
              </a>
            </Menu.Item>
          </Menu.Menu>
        </Container>
      </Menu>

      <Container style={{ marginTop: '7em', marginBottom: '5em' }}>
        <Header as='h1' textAlign='center'>
          <Icon name='building' />
          European Company Crawler
          <Header.Subheader>
            Multi-source company data aggregation from UK, France & Germany
          </Header.Subheader>
        </Header>

        <Divider />

        {/* Crawl Button */}
        {!crawled && (
          <div style={{ textAlign: 'center', margin: '2em 0' }}>
            <Button
              primary
              size='huge'
              onClick={handleCrawl}
              loading={loading}
              disabled={loading}
            >
              <Icon name='download' />
              Crawl Company Data
            </Button>
            <p style={{ marginTop: '1em', color: '#666' }}>
              Click to load company data from 3 European countries
            </p>
            <p style={{ marginTop: '0.5em', color: '#999', fontSize: '0.9em' }}>
              ℹ️ First request may take 50-60 seconds (free tier server wakes up from sleep)
            </p>
          </div>
        )}

        {/* Message */}
        {message && (
          <Message
            success={message.type === 'success'}
            error={message.type === 'error'}
            info={message.type === 'info'}
            onDismiss={() => setMessage(null)}
          >
            <Message.Header>
              {message.type === 'success' && '✅ Success'}
              {message.type === 'error' && '❌ Error'}
              {message.type === 'info' && 'ℹ️ Please wait'}
            </Message.Header>
            <p>{message.text}</p>
          </Message>
        )}

        {/* Statistics */}
        {companies.length > 0 && (
          <>
            <Divider />
            <Statistics companies={companies} />
            <Divider />
          </>
        )}

        {/* Search and Filters */}
        {companies.length > 0 && (
          <div style={{ margin: '2em 0' }}>
            <Input
              fluid
              icon='search'
              placeholder='Search by company name or registration number...'
              value={searchQuery}
              onChange={(e) => handleSearch(e.target.value)}
              size='large'
            />
            <div style={{ marginTop: '1em' }}>
              <Dropdown
                selection
                options={countryOptions}
                value={selectedCountry}
                onChange={(e, data) => handleCountryChange(data.value)}
                placeholder='Filter by country'
              />
              {filteredCompanies.length > 0 && (
                <span style={{ marginLeft: '1em', color: '#666' }}>
                  Showing {filteredCompanies.length} of {companies.length} companies
                </span>
              )}
            </div>
          </div>
        )}

        {/* Loading */}
        {loading && (
          <div style={{ textAlign: 'center', margin: '3em 0' }}>
            <Loader active inline='centered' size='huge'>
              {message?.type === 'info' ? 'Waking up server...' : 'Crawling company data...'}
            </Loader>
          </div>
        )}

        {/* Companies List */}
        {filteredCompanies.length > 0 && (
          <Card.Group>
            {filteredCompanies.map((company) => (
              <CompanyCard key={company.id} company={company} />
            ))}
          </Card.Group>
        )}

        {/* No Results */}
        {companies.length > 0 && filteredCompanies.length === 0 && (
          <Message info>
            <Message.Header>No companies found</Message.Header>
            <p>Try adjusting your search or filter criteria.</p>
          </Message>
        )}
      </Container>
    </div>
  );
}

export default App;