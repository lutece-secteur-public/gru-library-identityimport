/*
 * Copyright (c) 2002-2023, City of Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.identityimport.web.service;

import fr.paris.lutece.plugins.identitystore.v3.web.rs.dto.common.RequestAuthor;
import fr.paris.lutece.plugins.identitystore.v3.web.rs.dto.importing.BatchImportRequest;
import fr.paris.lutece.plugins.identitystore.v3.web.rs.dto.importing.BatchImportResponse;
import fr.paris.lutece.plugins.identitystore.v3.web.rs.dto.importing.BatchStatusRequest;
import fr.paris.lutece.plugins.identitystore.v3.web.rs.dto.importing.BatchStatusResponse;
import fr.paris.lutece.plugins.identitystore.web.exception.IdentityStoreException;

/**
 * Service regarding identity import.
 */
public class BatchImportService
{

    /** transport provider */
    private IBatchImportTransportProvider _transportProvider;

    /**
     * Simple Constructor
     */
    public BatchImportService( )
    {
        super( );
    }

    /**
     * Constructor with IIdentityTransportProvider in parameters
     *
     * @param transportProvider
     *            IIdentityImportTransportProvider
     */
    public BatchImportService( final IBatchImportTransportProvider transportProvider )
    {
        super( );
        this._transportProvider = transportProvider;
    }

    /**
     * setter of transportProvider parameter
     *
     * @param transportProvider
     *            IIdentityImportTransportProvider
     */
    public void setTransportProvider( final IBatchImportTransportProvider transportProvider )
    {
        this._transportProvider = transportProvider;
    }

    /**
     * Import a batch of identities. <br>
     * If the batch reference is empty, a new batch is created and the new reference is provided in the response. <br>
     * If the batch reference is provided in the request, the application will try to retrieve the batch and add the identities.
     * 
     * @param request
     *            the creation or update request
     * @param strClientCode
     *            the client code
     * @param author
     *            the author of the request
     * @return the reference of the created or update batch and an execution status.
     */
    public BatchImportResponse importBatch( final BatchImportRequest request, final String strClientCode, final RequestAuthor author )
            throws IdentityStoreException
    {
        return this._transportProvider.importBatch( request, strClientCode, author );
    }

    /**
     * Get the status of the batch
     * 
     * @param request
     *            the request containing the reference of the batch and the desired mode
     * @param strClientCode
     *            the client code
     * @param author
     *            the author
     * @return the status
     */
    public BatchStatusResponse getBatchStatus( final BatchStatusRequest request, final String strClientCode, final RequestAuthor author )
            throws IdentityStoreException
    {
        return this._transportProvider.getBatchStatus( request, strClientCode, author );
    }

}
